package org.val.win.consumer.impl.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.val.win.consumer.contract.dao.SecteurDao;
import org.val.win.model.bean.grimpe.Secteur;
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

    /**
     * Récuperer une liste des secteurs
     * @return
     */
    @Override
    public List<Secteur> getListSecteur(Integer id) {
        String vSQL = "SELECT * FROM public.secteur " +
                      "WHERE id_site = ?";

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

        List<Secteur> vListSecteur = vJdbcTemplate.query(vSQL, vRowMapper, id);

        return vListSecteur;
    }

    /**
     * Creer secteur
     * @param pSecteur
     */
    @Override
    public Secteur insertSecteur(Secteur pSecteur) {
        String vSQL = "INSERT INTO public.secteur " +
                "  (id_topo,\n" +
                "  id_site,\n" +
                "  nom_secteur,\n" +
                "  nrbvoie,\n" +
                "  difficulte,\n" +
                "  orientation,\n" +
                "  description)\n" +
                "VALUES\n" +
                "(:idTopo,:idSite,:nomSecteur,:nbrVoie,:difficulte,:orientation,:description)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("idTopo", pSecteur.getId_topo());
        vParams.addValue("idSite", pSecteur.getId_site());
        vParams.addValue("nomSecteur", pSecteur.getNom());
        vParams.addValue("nbrVoie", pSecteur.getNbrVoie());
        vParams.addValue("difficulte", pSecteur.getDifficulte());
        vParams.addValue("orientation", pSecteur.getOrientation());
        vParams.addValue("description", pSecteur.getDescription());

        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams, holder, new String[]{"id_secteur"});
        pSecteur.setId(holder.getKey().intValue());
        return pSecteur;
    }

    /**
     * Mettre a jour les informations d'un secteur
     * @param pSecteur
     */
    @Override
    public void updateInfoSecteur(Secteur pSecteur) {
        String vSQL = "UPDATE public.secteur " +
                "SET description = :description,\n" +
                "orientation = :orientation,\n" +
                "id_topo = :id_topo,\n" +
                "id_site = :id_site,\n" +
                "nom_secteur = :nom_secteur,\n" +
                "nrbvoie = :nrbvoie,\n" +
                "difficulte = :diffculte " +
                "WHERE id = :id";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pSecteur);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }

}
