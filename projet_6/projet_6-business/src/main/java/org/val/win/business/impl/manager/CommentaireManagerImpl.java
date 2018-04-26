package org.val.win.business.impl.manager;

import org.val.win.business.contract.manager.CommentaireManager;
import org.val.win.consumer.contract.dao.CommentaireDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.model.bean.utilisateur.Commentaire;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {

    @Inject
    private CommentaireDao commentaireDao;

    @Inject
    private TransactionHelper transactionHelper;

    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Recupérer les commentaires d'un topo
     * @param pId
     * @return
     */
    @Override
    public Commentaire getComTopo(Integer pId){
        Commentaire pCom = commentaireDao.getCommentaireTopo(pId);
        return pCom;
    }
}
