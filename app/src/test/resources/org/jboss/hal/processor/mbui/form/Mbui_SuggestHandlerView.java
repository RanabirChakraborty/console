package org.jboss.hal.processor.mbui.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import elemental.dom.Element;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.TemplateUtil;
import org.jboss.hal.ballroom.form.Form;
import org.jboss.hal.ballroom.table.Button;
import org.jboss.hal.ballroom.table.Options;
import org.jboss.hal.ballroom.LayoutBuilder;
import org.jboss.hal.ballroom.autocomplete.ReadChildrenAutoComplete;
import org.jboss.hal.core.mbui.dialog.AddResourceDialog;
import org.jboss.hal.core.mbui.form.GroupedForm;
import org.jboss.hal.core.mbui.form.ModelNodeForm;
import org.jboss.hal.core.mbui.table.ModelNodeTable;
import org.jboss.hal.core.mbui.table.NamedNodeTable;
import org.jboss.hal.core.mbui.MbuiContext;
import org.jboss.hal.dmr.model.Operation;
import org.jboss.hal.dmr.model.ResourceAddress;
import org.jboss.hal.meta.AddressTemplate;
import org.jboss.hal.meta.Metadata;
import org.jboss.hal.meta.security.Constraint;
import org.jboss.hal.resources.Ids;
import org.jboss.hal.spi.Message;
import org.jboss.hal.spi.MessageEvent;

import static java.util.Arrays.asList;
import static org.jboss.hal.dmr.ModelDescriptionConstants.ADD;
import static org.jboss.hal.dmr.ModelDescriptionConstants.READ_RESOURCE_OPERATION;

/*
 * WARNING! This class is generated. Do not modify.
 */
@Generated("org.jboss.hal.processor.mbui.MbuiViewProcessor")
final class Mbui_SuggestHandlerView extends SuggestHandlerView {

    private final Metadata metadata0;
    private final Map<String, Element> handlebarElements;

    @SuppressWarnings("unchecked")
    Mbui_SuggestHandlerView(MbuiContext mbuiContext) {
        super(mbuiContext);

        AddressTemplate metadata0Template = AddressTemplate.of("/subsystem=foo");
        this.metadata0 = mbuiContext.metadataRegistry().lookup(metadata0Template);
        this.handlebarElements = new HashMap<>();

        form = new ModelNodeForm.Builder<org.jboss.hal.dmr.ModelNode>("form", metadata0)
                .include("foo", "bar")
                .unsorted()
                .onSave((form, changedValues) -> saveSingletonForm("Form", metadata0Template.resolve(mbuiContext.statementContext()), changedValues))
                .prepareReset(form -> resetSingletonForm("Form", metadata0Template.resolve(mbuiContext.statementContext()), form, metadata0))
                .build();
        form.getFormItem("foo").registerSuggestHandler(new ReadChildrenAutoComplete(
                mbuiContext.dispatcher(), mbuiContext.statementContext(), AddressTemplate.of("/foo=*")));
        List<AddressTemplate> formTemplates = asList(
                AddressTemplate.of("/bar=*"),
                AddressTemplate.of("/another-bar=*"));
        form.getFormItem("bar").registerSuggestHandler(new ReadChildrenAutoComplete(
                mbuiContext.dispatcher(), mbuiContext.statementContext(), formTemplates));

        LayoutBuilder layoutBuilder = new LayoutBuilder()
                .row()
                .column()
                .div()
                .innerHtml(SafeHtmlUtils.fromSafeConstant("<h1>Form</h1>"))
                .rememberAs("html0")
                .end()
                .add(form)
                .end()
                .end();
        handlebarElements.put("html0", layoutBuilder.referenceFor("html0"));

        registerAttachable(form);

        Element root = layoutBuilder.build();
        initElement(root);
    }

    @Override
    public void attach() {
        super.attach();
    }
}