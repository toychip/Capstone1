package com.ttt.capstone.config;

import com.ttt.capstone.config.data.UserSession;
import com.ttt.capstone.domian.Session;
import com.ttt.capstone.exception.Unauthorized;
import com.ttt.capstone.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Optional;

@RequiredArgsConstructor
public class AuthResolver implements HandlerMethodArgumentResolver {

    private final SessionRepository sessionRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserSession.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        String accesToken = webRequest.getHeader("Authorization");
        if (accesToken == null||accesToken.equals("")){
            throw new Unauthorized();
        }

        // 값이 있다면
        Session session = sessionRepository.findByAccessToken(accesToken)
                .orElseThrow(Unauthorized::new);

        // db 사용자 확인 작업 추가 예정
        return new UserSession(session.getMember().getId());

    }
}
