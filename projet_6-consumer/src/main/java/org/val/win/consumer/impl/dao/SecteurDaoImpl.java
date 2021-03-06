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
     * @return une liste de secteur vListSeceur
     */
    @Override
    public List<Secteur> getListSecteur(Integer id) {
        String vSQL = "SELECT * FROM public.secteur " +
                      "WHERE id_site = ?";

        RowMapper<Secteur> vRowMapper = new RowMapper<Secteur>() {
            public Secteur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Secteur vSecteur = new Secteur(pRS.getInt("id_secteur"));
                vSecteur.setNomSecteur(pRS.getString("nom_secteur"));
                vSecteur.setDescription(pRS.getString("description"));
                vSecteur.setDifficulte(pRS.getString("difficulte"));
                vSecteur.setOrientation(pRS.getString("orientation"));
                return vSecteur;
            }
        };

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Secteur> vListSecteur = vJdbcTemplate.query(vSQL, vRowMapper, id);

        return vListSecteur;
    }

    /**
     * Creer secteur
     * @param pSecteur prend un secteur en paramètre
     * @return renvoie le secteur
     */
    @Override
    public Secteur insertSecteur(Secteur pSecteur) {
        String vSQL = "INSERT INTO public.secteur " +
                "  (id_topo,\n" +
                "  id_site,\n" +
                "  nom_secteur,\n" +
                "  difficulte,\n" +
                "  orientation,\n" +
                "  description)\n" +
                "VALUES\n" +
                "(:idTopo,:idSite,:nomSecteur,:difficulte,:orientation,:description)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("idTopo", pSecteur.getIdTopo());
        vParams.addValue("idSite", pSecteur.getIdSite());
        vParams.addValue("nomSecteur", pSecteur.getNomSecteur());
        vParams.addValue("difficulte", pSecteur.getDifficulte());
        vParams.addValue("orientation", pSecteur.getOrientation());
        vParams.addValue("description", pSecteur.getDescription());

        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams, holder, new String[]{"id_secteur"});
        pSecteur.setIdSecteur(holder.getKey().intValue());
        return pSecteur;
    }

    /**
     * Mettre a jour les informations d'un secteur
     * @param pSecteur prend un secteur en paramètre
     */
    @Override
    public void updateInfoSecteur(Secteur pSecteur) {
        String vSQL = "UPDATE public.secteur " +
                "SET description = :description,\n" +
                "orientation = :orientation,\n" +
                "id_topo = :idTopo,\n" +
                "id_site = :idSite,\n" +
                "nom_secteur = :nomSecteur,\n" +
                "difficulte = :diffculte " +
                "WHERE id = :id";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pSecteur);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }

}
