package com.example.demo.config.interceptor;

import com.example.demo.config.Auth;
import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DefaultInterceptor implements HandlerInterceptor {
    private final JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, BaseException {
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Auth auth = handlerMethod.getMethodAnnotation(Auth.class);

        if (auth != null) {
            //token 있는지 check getuserinfo에서 처리
            String token = jwtService.getJwt(request);

            String role = auth.role().getKey().toString();
            if (role.equals("ROLE_USER")) {

                //role 일치하는지 check
                Map<String, Object> userInfo = jwtService.getUserInfo(token);
                if (!(userInfo.get("role").equals("ROLE_USER")))
                    throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
                Long tokenIdx = (Long) userInfo.get("userIdx");

                //idx 일치하는지  check
                Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
                if (pathVariables.get("userIdx")!=null) {
                    Long pathVariableIdx = (Long) pathVariables.get("userIdx");
                    if (!(pathVariableIdx.equals(tokenIdx)))
                        throw new BaseException(BaseResponseStatus.USERS_EMPTY_USER_IDX);
                }
                request.setAttribute("userIdx", tokenIdx);
            } else if (role.equals("ROLE_BUSINESS_USER")) {

                //role 일치하는지 check
                Map<String, Object> userInfo = jwtService.getUserInfo(token);
                if (!(userInfo.get("role").equals("ROLE_BUSINESS_USER")))
                    throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
                Long tokenIdx = (Long) userInfo.get("userIdx");
                //idx 일치하는지  check
                Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
                if (pathVariables.get("businessUserIdx") != null) {
                    Long pathVariableIdx = (Long) pathVariables.get("userIdx");
                    if (!(tokenIdx.equals(pathVariableIdx)))
                        throw new BaseException(BaseResponseStatus.USERS_EMPTY_USER_IDX);
                }
                request.setAttribute("businessUserIdx", tokenIdx);
            }


        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handle, ModelAndView modelAndView) throws Exception {
    }

}
