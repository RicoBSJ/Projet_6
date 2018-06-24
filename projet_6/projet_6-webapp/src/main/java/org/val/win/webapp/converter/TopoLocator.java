package org.val.win.webapp.converter;

import java.util.Map;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.exception.NotFoundException;


/**
 * Locator d'{@link Topo} via son idt.
 */
public class TopoLocator extends StrutsTypeConverter {

    @Inject
    private ManagerFactory managerFactory;

    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour
                            = StringUtils.isEmpty(vValue)
                            ? null
                            : managerFactory.getTopoManager().getTopo(new Integer(vValue));
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format d'identifiant du Site invalide", pEx);
                } catch (NotFoundException pEx) {
                    throw new TypeConversionException("Site introuvable", pEx);
                }
            } else {
                vRetour = performFallbackConversion(pContext, pValues, pToClass);
            }
        }
        return vRetour;
    }

    @Override
    public String convertToString(Map pContext, Object pObject) {
        String vString;
        if (pObject instanceof Topo) {
            Topo vTopo = (Topo) pObject;
            vString
                    = vTopo.getIdTopo() != null
                    ? vTopo.getIdTopo().toString()
                    : "";
        } else {
            vString = "";
        }
        return vString;
    }
}
