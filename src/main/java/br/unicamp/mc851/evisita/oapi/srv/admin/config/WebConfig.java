package br.unicamp.mc851.evisita.oapi.srv.admin.config;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@NoArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(CustomHandlerMethodArgumentResolver.LOOGED_ADMIN_REQUEST);
    }
}
