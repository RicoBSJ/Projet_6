package org.val.win.webapp.converter;

import java.util.Map;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.exception.NotFoundException;


/**
 * Locator d'{@link Site} via son idt.
 */
public class SiteLocator extends StrutsTypeConverter {


    @Inject
    private ManagerFactory managerFactory;


    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                String [] tokens = vValue.split("#");
                String siteID = tokens[0].trim();
                String topoID = tokens[1].trim();
                try {
                    vRetour
                            = StringUtils.isEmpty(vValue)
                            ? null
                            : managerFactory.getSiteManager().getSite(new Integer(siteID), new Integer(topoID));
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format d'identifiant de Site invalide", pEx);
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
        if (pObject instanceof Site) {
            Site vSite = (Site) pObject;
            vString
                    = vSite.getId() != null
                    ? vSite.getId().toString()
                    : "";
        } else {
            vString = "";
        }
        return vString;
    }
}
