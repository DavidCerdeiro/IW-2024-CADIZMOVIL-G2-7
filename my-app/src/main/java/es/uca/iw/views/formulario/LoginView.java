package es.uca.iw.views.formulario;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import es.uca.iw.views.MainLayout;
import es.uca.iw.views.helloworld.HelloWorldView;

// ... (existing imports)

@PageTitle("Login")
@Route(value = "login", layout = MainLayout.class)
@Uses(Icon.class)
public class LoginView extends Composite<VerticalLayout> {

    public LoginView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H3 h3 = new H3();
        FormLayout formLayout2Col = new FormLayout();
        EmailField emailField = new EmailField();
        emailField.setRequiredIndicatorVisible(true);

        PasswordField contra = new PasswordField();
        contra.setRequiredIndicatorVisible(true);

        Image logoImage = new Image("icons/logo.png", "logo of the site");
        logoImage.setWidth("315px");

        HorizontalLayout layoutRow = new HorizontalLayout();
        Button baceptar = new Button();
        Button bcancelar = new Button();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        Paragraph textLarge = new Paragraph();
        Button bregistrar = new Button();

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);

        layoutColumn2.setWidth("100%");
        layoutColumn2.setMaxWidth("800px");
        layoutColumn2.setHeight("min-content");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.CENTER);

        logoImage.getStyle().set("margin-bottom", "20px"); // Add margin to the bottom of the logo
        layoutColumn2.add(logoImage);

        h3.setText("Iniciar Sesión");
        h3.setWidth("100%");

        layoutColumn2.add(h3);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(emailField);
        formLayout2Col.add(contra);

        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        baceptar.setText("Save");
        baceptar.setWidth("min-content");
        baceptar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        bcancelar.setText("Cancel");
        bcancelar.setWidth("min-content");
        bcancelar.addClickListener(event -> navigateToHelloWorldView());

        layoutRow.add(baceptar);
        layoutRow.add(bcancelar);

        layoutColumn2.add(layoutRow);

        layoutRow2.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutRow2.setAlignItems(Alignment.CENTER);
        layoutRow2.setJustifyContentMode(JustifyContentMode.CENTER);

        textLarge.setText("¿No tienes una cuenta todavía?");
        textLarge.setWidth("100%");
        textLarge.getStyle().set("font-size", "var(--lumo-font-size-xl)");

        bregistrar.setText("Registrarse");
        bregistrar.addClickListener(event -> navigateToLoginView());
        bregistrar.setWidth("min-content");
        bregistrar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        layoutRow2.add(textLarge);
        layoutRow2.add(bregistrar);

        layoutColumn2.add(new VerticalSpacer(), layoutRow2);

        getContent().add(layoutColumn2);
    }

    private void navigateToLoginView() {
        UI.getCurrent().navigate(FormularioView.class);
    }

    private void navigateToHelloWorldView() {
        UI.getCurrent().navigate(HelloWorldView.class);
    }

    public static class VerticalSpacer extends Div {
        public VerticalSpacer() {
            setHeight("1em");
        }
    }
}
