package br.unicamp.mc851.evisita.oapi.srv.admin.config.security.util;

import br.unicamp.mc851.evisita.oapi.srv.admin.domain.Admin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Base64;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenUtil {

    public static Admin getCurrentLoggedAdmin(String token) {
        if (!StringUtils.hasText(token)) {
            return null;
        }

        return resolveToken(token);
    }

    private static Admin resolveToken(String token) {
        token = token.replace("Bearer ", "");
        var strings = token.split("\\.");
        var payload = new String(Base64.getDecoder().decode(strings[1]));

        return buildLoggedAdminFromJson(payload);
    }

    private static Admin buildLoggedAdminFromJson(String json) {
        if (!StringUtils.hasText(json)) {
            return null;
        }

        var objectMapper = new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());

        try {
            return objectMapper.readValue(json, Admin.class);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return null;
        }

    }
}
