package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.SecteurDao;
import org.exemple.demo.model.bean.grimpe.Secteur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {

    @Override
    public List<Secteur> getSecteur() {
        String vSQL = "SELECT * FROM public.secteur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Secteur> vRowMapper = new RowMapper<Secteur>() {
            public Secteur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Secteur vSecteur = new Secteur(pRS.getInt("id_secteur"));
                vSecteur.setNom(pRS.getString("nom"));
                vSecteur.setNbrVoie(pRS.getInt("nbrVoie"));
                vSecteur.setDescription(pRS.getString("description"));
                vSecteur.setDifficulte(pRS.getString("difficulte"));
                vSecteur.setOrientation(pRS.getString("orientation"));
                return vSecteur;
            }
        };
        List<Secteur> vListSecteur = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListSecteur;
    }


}
