package com.simpleshop.products;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.*;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "SimpleShop Product Service API Definition",
                description = """
                        Welcome to the **SimpleShop Product Service API**! This API allows clients and administrators to efficiently manage 
                        and retrieve products, category, and brand information within the SimpleShop platform.

                        ### Key Features
                        - **Product Management**: Create, update, and retrieve detailed information about products, including pricing, dimensions, and stock status.
                        - **Category Management**: Organize products into categories, manage parent-child relationships, and list categories.
                        - **Brand Management**: Manage and retrieve information about products brands.
                        - **Pagination and Sorting**: Easily paginate through large datasets with flexible sorting options.
                        - **Error Handling**: Comprehensive error responses with detailed descriptions for debugging.
                        """,
                termsOfService = "http://simpleshop/terms/",
                contact = @Contact(
                        name = "API Support",
                        url = "http://simpleshop/support",
                        email = "support@simpleshop.com"
                ),
                license = @License(
                        name = "SimpleShop License",
                        url = "http://simpleshop/licenses/LICENSE-2.0.html"
                ),
                version = "0.0.1"
        ),
        security = @SecurityRequirement(name = "oauth2_bearer"),
        servers = @Server(
                url = "${server.servlet.context-path}",
                description = "Local Development Server"
        )
)
@SecurityScheme(name = "oauth2_bearer", type = SecuritySchemeType.OAUTH2,
        flows = @OAuthFlows(
                authorizationCode = @OAuthFlow(
                        authorizationUrl = "${springdoc.oauthflow.authorization-url}",
                        tokenUrl = "${springdoc.oauthflow.token-url}",
                        scopes = {@OAuthScope(name = "openid", description = "")
                        })))
public class SpringDocConfiguration {
}
