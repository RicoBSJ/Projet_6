package org.val.win.business.impl.manager;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.val.win.business.contract.manager.CommentaireManager;
import org.val.win.consumer.contract.dao.CommentaireDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.model.bean.utilisateur.Commentaire;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Classe de gestion des transactions pour les commentaires
 */
@Named
public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {

    /**
     * creation du dao des commentaires
     */
    @Inject
    private CommentaireDao commentaireDao;

    /**
     * creation d'un platformTransactionManager pour gerer les transactions
     */
    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Recupérer les commentaires d'un topo
     * @param pId id du topo en parametre
     * @return liste de commentaire
     */
    @Override
    public List<Commentaire> getCommentaireTopo(Integer pId) {
        List<Commentaire> pCom = commentaireDao.getCommentaireTopo(pId);
        return pCom;
    }

    /**
     * Creer un commentaire
     * @param pCom le commentaire a creer
     */
    @Override
    public void insertCom(Commentaire pCom) {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                commentaireDao.insertCommentaire(pCom);
            }
        });
    }
}

