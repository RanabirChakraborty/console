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
package org.jboss.hal.client.utb;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import org.jboss.hal.core.mvp.HasPresenter;
import org.jboss.hal.core.mvp.PatternFlyPresenter;
import org.jboss.hal.core.mvp.PatternFlyView;
import org.jboss.hal.core.mvp.Slots;
import org.jboss.hal.core.TopLevelCategory;
import org.jboss.hal.dmr.ModelNode;

import javax.inject.Inject;

/**
 * @author Harald Pehl
 */
public class UnderTheBridgePresenter extends
        PatternFlyPresenter<UnderTheBridgePresenter.MyView, UnderTheBridgePresenter.MyProxy>
        implements TopLevelCategory {

    // @formatter:off
    @ProxyCodeSplit
    @NameToken(org.jboss.hal.meta.token.NameTokens.UNDER_THE_BRIDGE)
    public interface MyProxy extends ProxyPlace<UnderTheBridgePresenter> {}

    public interface MyView extends PatternFlyView, HasPresenter<UnderTheBridgePresenter> {
        void show(ModelNode model);
    }
    // @formatter:on

    private ModelNode model;

    @Inject
    public UnderTheBridgePresenter(final EventBus eventBus,
            final MyView view,
            final MyProxy proxy) {
        super(eventBus, view, proxy, Slots.MAIN);
        model = new ModelNode();
    }

    @Override
    protected void onBind() {
        super.onBind();
        getView().setPresenter(this);
    }

    @Override
    protected void onReset() {
        super.onReset();
        getView().show(model);
    }

    public void saveModel(final ModelNode model) {
        this.model = model;
        getView().show(model);
    }
}