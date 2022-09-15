/*
 * #%L
 * Wildfly Camel
 * %%
 * Copyright (C) 2013 - 2015 RedHat
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
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
