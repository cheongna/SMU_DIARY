package com.smudiary.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenApiCustomizer openApiCustomizer() {
        return new OpenApiCustomizer() {
            @Override
            public void customise(OpenAPI openApi) {
                SecurityScheme basicAuth = new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("Basic")
                        .description("Basic 인증");
                openApi.getComponents()
                        .addSecuritySchemes("BasicAuth", basicAuth);

                SecurityRequirement basicAuthRequirement = new SecurityRequirement()
                        .addList("basicAuth");
                openApi.addSecurityItem(basicAuthRequirement);
            }
        };
    }
}
