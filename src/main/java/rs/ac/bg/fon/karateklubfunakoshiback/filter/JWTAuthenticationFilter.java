package rs.ac.bg.fon.karateklubfunakoshiback.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import rs.ac.bg.fon.karateklubfunakoshiback.service.CustomUserDetailsService;
import rs.ac.bg.fon.karateklubfunakoshiback.utility.JWTUtility;

/*
It extracts the JWT from the request, verifies its authenticity using the digital signature, 
and performs additional checks such as expiration time, issuer, and audience validation. 
If the JWT is valid, the filter allows the request to proceed to the intended endpoint. 
If the JWT is invalid or missing, the filter can reject the request or redirect the user to an appropriate error page or authentication flow.
*/
@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter implements Filter {
    @Autowired
    private JWTUtility jwtUtility;
    @Autowired
    private CustomUserDetailsService userDetailsService;


    //Only one per request
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String token = request.getHeader("Authorization");
            System.out.println("JWTFilter: Authorization: " + token);
        if (token==null || token.equals("null")) {
            filterChain.doFilter(request, response);
            return;
        }
        if(!request.getServletPath().equals("/api/trainer/login")){
            UserDetails userDetails = userDetailsService
                    .loadUserByUsername(jwtUtility.extractUsername(token));
            System.out.println(userDetails);
            UsernamePasswordAuthenticationToken
                    authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null,
                    userDetails == null ?
                            List.of() : userDetails.getAuthorities()
            );
            if (!jwtUtility.validateToken(token, userDetails)) {
                filterChain.doFilter(request, response);
                return;
            }

            System.out.println(authentication);
            authentication.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        }


    }


    }


