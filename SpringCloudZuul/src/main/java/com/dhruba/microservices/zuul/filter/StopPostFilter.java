package com.dhruba.microservices.zuul.filter;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class StopPostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = getCurrentContext();
		Instant stop = Instant.now();
		Instant start = (Instant)context.get("starttime");
		long millisecondsDifference = ChronoUnit.MILLIS.between(start, stop);
		System.out.println("Call took " + millisecondsDifference + " milliseconds");
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
