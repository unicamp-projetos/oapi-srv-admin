package br.unicamp.mc851.evisita.oapi.srv.admin.config;

import br.unicamp.mc851.evisita.oapi.srv.admin.config.security.util.AdminLogin;
import br.unicamp.mc851.evisita.oapi.srv.admin.config.security.util.TokenUtil;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class CustomHandlerMethodArgumentResolver {

    public static final HandlerMethodArgumentResolver LOOGED_ADMIN_REQUEST = new HandlerMethodArgumentResolver() {

        private final String AUTHORIZATION_HEADER = "Authorization";

        @Override
        public boolean supportsParameter(MethodParameter methodParameter) {
            return methodParameter.getParameterAnnotation(AdminLogin.class) != null;
        }

        @Override
        public Object resolveArgument(MethodParameter methodParameter,
                                      ModelAndViewContainer modelAndViewContainer,
                                      NativeWebRequest nativeWebRequest,
                                      WebDataBinderFactory webDataBinderFactory) throws Exception {
            var request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
            var token = request.getHeader(AUTHORIZATION_HEADER);

            if (!StringUtils.hasText(token)) {
                return null;
            }

            return TokenUtil.getCurrentLoggedAdmin(token);
        }
    };
}
