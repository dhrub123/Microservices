package com.justgifit.autoconfigure;

import java.io.File;

import javax.inject.Inject;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.justgifit.autoconfigure.services.ConverterService;
import com.justgifit.autoconfigure.services.GifEncoderService;
import com.justgifit.autoconfigure.services.VideoDecoderService;
import com.madgag.gif.fmsware.AnimatedGifEncoder;

@Configuration
@ConditionalOnClass({FFmpegFrameGrabber.class, AnimatedGifEncoder.class})
@EnableConfigurationProperties(JustGifItProperties.class)
public class JustGifItAutoConfiguration {
	
	//implementation for missing bean scenario
	@Bean
	@ConditionalOnMissingBean(VideoDecoderService.class)
	public VideoDecoderService videoDecoderService() {
		return new VideoDecoderService();
	}
	
	@Bean
	@ConditionalOnMissingBean(ConverterService.class)
	public ConverterService converterService() {
		return new ConverterService();
	}
	
	@Bean
	@ConditionalOnMissingBean(GifEncoderService.class)
	public GifEncoderService gifEncoderService() {
		return new GifEncoderService();
	}
	
	@Inject
	private JustGifItProperties properties;
	
	@ConditionalOnProperty(prefix = "com.justgifit", name="create-result-dir")
    private void createResultDirectory() {
        if (!properties.getGifLocation().exists()) {
        	properties.getGifLocation().mkdir();
        }
    }
	
	@Configuration
	@ConditionalOnWebApplication
	public static class WebConfiguration{
		
		@Value("${spring.servlet.multipart.location}/gif/")
	    private String gifLocation;
		
		@SuppressWarnings("deprecation")
		@Bean
	    public WebMvcConfigurer webMvcConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addResourceHandlers(ResourceHandlerRegistry registry) {
	                registry.addResourceHandler("/gif/**")
	                        .addResourceLocations("file:" + gifLocation);
	                super.addResourceHandlers(registry);
	            }
	        };
	    }
	}
	
	

}
