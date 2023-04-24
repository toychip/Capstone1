package com.ttt.capstone.config;

import com.ttt.capstone.config.data.UserSession;
import com.ttt.capstone.domian.Session;
import com.ttt.capstone.exception.Unauthorized;
import com.ttt.capstone.repository.SessionRepository;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class AuthResolver implements HandlerMethodArgumentResolver {

    private final SessionRepository sessionRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserSession.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        String jws = webRequest.getHeader("Authorization");
        if (jws == null || jws.equals("")){
            log.info("jws null");
            throw new Unauthorized();
        }

        try {

            Jwts.parserBuilder()
                    .setSigningKey("C")
                    .build()
                    .parseClaimsJws(jws);

            //OK, we can trust this JWT 복호화 성공

        } catch (JwtException e) { // 복호화 실패
            throw new Unauthorized();
        }

        // db 사용자 확인 작업 추가 예정
//        return new UserSession(session.getMember().getId());
        return null;
    }
}
