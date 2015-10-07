/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.hal.ballroom.layout;

import elemental.dom.Element;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.hal.ballroom.GridSpec;

/**
 * @author Harald Pehl
 */
public class LayoutBuilder implements GridSpec {

    private final Elements.Builder eb;

    public LayoutBuilder() {
        // start the top level "row" div
        eb = new Elements.Builder().div().css("row");
    }

    public LayoutBuilder header(String title) {
        eb.div().css("col-" + COLUMN_DISCRIMINATOR + "-12").h(1).innerText(title).end().end();
        return this;
    }

    public LayoutBuilder header(String title, Element element) {
        eb.div().css("col-" + COLUMN_DISCRIMINATOR + "-12").h(1).innerText(title).end().add(element).end();
        return this;
    }

    public LayoutBuilder header(Element element) {
        eb.div().css("col-" + COLUMN_DISCRIMINATOR + "-12").add(element).end();
        return this;
    }

    public LayoutBuilder add(Element... elements) {
        if (elements != null) {
            eb.div().css("col-" + COLUMN_DISCRIMINATOR + "-12");
            for (Element element : elements) {
                eb.add(element);
            }
            eb.end();
        }
        return this;
    }

    public Element build() {
        // close and return the top level "row" div
        return eb.end().build();
    }
}