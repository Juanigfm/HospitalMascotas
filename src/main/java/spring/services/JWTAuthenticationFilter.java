package spring.services;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;


@WebFilter(filterName = "jwt-auth-filter", urlPatterns = "*")
public class JWTAuthenticationFilter implements Filter {

    public JWTAuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// El login del usuarios es publico
		if ("/25/usuario/veterinario".equals(req.getRequestURI()) || "/25/usuario/dueno".equals(req.getRequestURI()) || HttpMethod.OPTIONS.matches(req.getMethod())) {           
			chain.doFilter(request, response);
			return;       
		}
		String token = req.getHeader(HttpHeaders.AUTHORIZATION);
		if (token == null || !TokenService.validateToken(token)) {
		//if (token == null) {
			HttpServletResponse res = (HttpServletResponse) response;           
			res.setStatus(HttpStatus.FORBIDDEN.value());
			return;       
		}       
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
