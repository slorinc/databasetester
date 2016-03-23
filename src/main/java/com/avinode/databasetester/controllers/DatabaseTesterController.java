package com.avinode.databasetester.controllers;

import com.avinode.databasetester.dto.FormDTO;
import com.avinode.databasetester.dto.FormDTOBuilder;
import com.avinode.databasetester.dto.QueryResult;
import com.avinode.databasetester.services.DatabaseQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;
import javax.validation.Valid;

/**
 * DatabaseTesterController
 *
 * @author <a href="mailto:lorinc.sonnevend@avinode.com">Lorinc Sonnevend</a>
 *         <p>
 *         Created on 23/03/16.
 */
@Controller("databaseController")
@RequestMapping("internal/testing")
public class DatabaseTesterController {

    @Autowired
    private DatabaseQueryService databaseQueryService;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @RequestMapping
    public String load(Model model) {
        model.addAttribute("formDTO", new FormDTOBuilder()
                .setNumberOfTimes(1)
                .setDatasourceUrl(datasourceUrl)
                .setDatasourceUsername(datasourceUsername)
                .setDatasourcePassword(datasourcePassword)
                .createFormDTO());
        return "form";
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    public String handleFromPost(@Valid @ModelAttribute FormDTO formDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        DataSource dataSource = DataSourceBuilder.create()
                .username(formDTO.getDatasourceUsername())
                .password(formDTO.getDatasourcePassword())
                .url(formDTO.getDatasourceUrl())
                .driverClassName(driverClassName)
                .build();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setSkipResultsProcessing(true);

        QueryResult queryResult = databaseQueryService.executeQuery(jdbcTemplate, formDTO.getNumberOfTimes(), formDTO.getSqlStatement());

        model.addAttribute("executionTime", queryResult.getExecutionTime());
        model.addAttribute("errorList", queryResult.getErrorList());
        return "form";
    }

}
