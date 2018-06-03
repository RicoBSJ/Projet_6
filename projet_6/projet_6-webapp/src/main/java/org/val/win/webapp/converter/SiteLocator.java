package org.val.win.webapp.converter;

import java.util.Map;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.StrutsTypeConverter;
import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.exception.NotFoundException;


/**
 * Locator d'{@link Site} via son idt.
 */
public class SiteLocator extends StrutsTypeConverter implements SessionAware {

    /**
     * Récuperer session
     */
    private Map<String, Object> session;

    /**
     * Setteur pour la session
     * @param pSession
     */
    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    @Inject
    private ManagerFactory managerFactory;

    private Topo topo;


    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        topo = (Topo) session.get("topo");

        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour
                            = StringUtils.isEmpty(vValue)
                            ? null
                            : managerFactory.getSiteManager().getSite(new Integer(vValue), topo.getIdTopo());
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
