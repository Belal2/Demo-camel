
package org.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

public class MyBean {
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		Message out = exchange.getOut();
//		
		ContentType conType = ContentType.create(in.getAttachment("imageFile").getContentType());
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create().addBinaryBody("imageFile",
				in.getAttachment("imageFile").getInputStream(), conType, in.getAttachment("imageFile").getName());
		HttpEntity resultEntity = multipartEntityBuilder.build();
		out.setHeader(Exchange.HTTP_METHOD, "POST");
		out.setHeader(Exchange.CONTENT_TYPE, in.getHeader(Exchange.CONTENT_TYPE));
		if (resultEntity.getContentLength() <= 25 * 1024) {
			out.setBody(resultEntity);
		} else {
			final ByteArrayOutputStream os = new ByteArrayOutputStream();
			resultEntity.writeTo(os);
			os.flush();
			out.setBody(new ByteArrayInputStream(os.toByteArray()));
		}

	}

}
