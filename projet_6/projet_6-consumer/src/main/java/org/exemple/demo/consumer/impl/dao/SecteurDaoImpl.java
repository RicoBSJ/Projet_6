package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.SecteurDao;
import org.exemple.demo.model.bean.grimpe.Secteur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {

    @Override
    public List<Secteur> getListSecteur() {
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

    @Override
    public void insertSecteur(Secteur pSecteur) {
        String vSQL = "INSERT INTO public.secteur " +
                "  (id_secteur,\n" +
                "  id_topo,\n" +
                "  id_site,\n" +
                "  nom_secteur,\n" +
                "  nrbvoie,\n" +
                "  difficulte,\n" +
                "  orientation,\n" +
                "  description)\n" +
                "VALUES\n" +
                "( '?', '?', '?', '?', '?', '?', '?', '?')";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_secteur", pSecteur.getId());
        vParams.addValue("id_site", pSecteur.getId_site());
        vParams.addValue("id_topo", pSecteur.getId_topo());
        vParams.addValue("nom_secteur", pSecteur.getNom());
        vParams.addValue("nbrvoie", pSecteur.getNbrVoie());
        vParams.addValue("description", pSecteur.getDescription());
        vParams.addValue("orientation", pSecteur.getOrientation());
        vParams.addValue("difficulte", pSecteur.getDifficulte());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }

}
