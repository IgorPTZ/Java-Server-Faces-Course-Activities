package br.com.devdojo.maratonajsf.converters;

import br.com.devdojo.maratonajsf.model.Estudante;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.List;
import java.util.Map;

@FacesConverter(value="estudanteConverter")
public class EstudanteConverter implements Converter {

    private List<Estudante> estudanteList = Estudante.obterListaDeEstudantes();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {

        if(value == null || !value.matches("\\d+")) {
            return null;
        }

        return this.getAttributesFrom(uiComponent).get(value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {

        if(value != null && !value.equals("")) {
            Estudante estudante = (Estudante) value;

            if(estudante.getId() != null) {
                this.addAttribute(uiComponent, estudante);
                return estudante.getId().toString();
            }
        }

        return null;
    }

    private Map<String, Object> getAttributesFrom(UIComponent componente) {
        return componente.getAttributes();
    }

    private void addAttribute(UIComponent componente, Estudante estudante) {
        this.getAttributesFrom(componente).put(estudante.getId().toString(), estudante);
    }
}
