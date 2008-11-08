/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2008 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package com.sun.mail.dsn;

import java.io.*;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * A special MimeMessage object that contains only message headers,
 * no content.  Used to represent the MIME type text/rfc822-headers.
 *
 * @since	JavaMail 1.4
 */
public class MessageHeaders extends MimeMessage {

    /**
     * Construct a MessageHeaders object.
     */
    public MessageHeaders() throws MessagingException {
	super((Session)null);
	content = new byte[0];
    }

    /**
     * Constructs a MessageHeaders object from the given InputStream.
     *
     * @param	is	InputStream
     */
    public MessageHeaders(InputStream is) throws MessagingException {
	super(null, is);
	content = new byte[0];
    }

    /**
     * Constructs a MessageHeaders object using the given InternetHeaders.
     *
     * @param	headers	InternetHeaders to use
     */
    public MessageHeaders(InternetHeaders headers) throws MessagingException {
	super((Session)null);
	this.headers = headers;
	content = new byte[0];
    }

    /**
     * Return the size of this message.
     * Always returns zero.
     */
    public int getSize() {
	return 0;
    }

    public InputStream getInputStream() {
	return new ByteArrayInputStream(content);
    }

    protected InputStream getContentStream() {
	return new ByteArrayInputStream(content);
    }

    /**
     * Can't set any content for a MessageHeaders object.
     *
     * @exception	MessagingException	always
     */
    public void setDataHandler(DataHandler dh) throws MessagingException {
	throw new MessagingException("Can't set content for MessageHeaders");
    }

}
