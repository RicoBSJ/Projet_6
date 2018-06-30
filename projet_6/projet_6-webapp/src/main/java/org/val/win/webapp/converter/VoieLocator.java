package org.val.win.webapp.converter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Voie;
import org.val.win.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.Map;

/**
 * Locator d'{@link Voie} via son idt.
 */
public class VoieLocator extends StrutsTypeConverter {

    /**
     * Recuperer manager Factory
     */
    @Inject
    private ManagerFactory managerFactory;


    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                String [] tokens = vValue.split("#");
                String VoieID = tokens[0].trim();
                String SecteurID = tokens[1].trim();
                try {
                    vRetour
                            = StringUtils.isEmpty(vValue)
                            ? null
                            : managerFactory.getVoieManager().getVoie(new Integer(VoieID), new Integer(SecteurID));
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format d'identifiant de la voie invalide", pEx);
                } catch (NotFoundException pEx) {
                    throw new TypeConversionException("Voie Introuvable", pEx);
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
        if (pObject instanceof Voie) {
            Voie vVoie = (Voie) pObject;
            vString
                    = vVoie.getIdVoie() != null
                    ? vVoie.getIdVoie().toString()
                    : "";
        } else {
            vString = "";
        }
        return vString;
    }
}
