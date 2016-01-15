package bean;

import formation.domain.ParamtypeQuestion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by victor on 12/01/2016.
 */
@ManagedBean(name = "selectItemsConverter")
@RequestScoped
@FacesConverter(value = "selectItemsConverter", forClass = ParamtypeQuestion.class)
public class SelectItemsConverter implements Converter
{
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;

    private ParamtypeQuestion param = new ParamtypeQuestion();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        /*System.out.println(StaticList.getList());
        System.out.println(StaticList.getList().size());
        System.out.println(StaticList.getList().keySet());*/
        param = StaticList.getList().get(value);
        return param;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value){
        param = (ParamtypeQuestion) value;
        return param.getLibelle();
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof ParamtypeQuestion) && (param.getIdType() > -1)
                ? param.equals(((ParamtypeQuestion) other).getIdType())
                : (other == this);
    }
}



