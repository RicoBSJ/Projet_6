package org.val.win.consumer.impl.dao;


import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.val.win.consumer.contract.dao.VoieDao;
import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.bean.grimpe.Voie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao {

    /**
     * Récuperer toutes les voies
     * @param id d'un secteur
     * @return une liste de voie
     *
     */
    @Override
    public List<Voie> getListVoie(Integer id) {
        String vSQL = "SELECT * FROM public.voie " +
                      "WHERE id_secteur = ?";

        RowMapper<Voie> vRowMapper = new RowMapper<Voie>() {
            public Voie mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Voie vVoie = new Voie(pRS.getInt("id_voie"));
                vVoie.setNomVoie(pRS.getString("nom_voie"));
                vVoie.setCotation(pRS.getString("cotation"));
                vVoie.setDescription(pRS.getString("description"));
                vVoie.setHauteur(pRS.getFloat("hauteur"));
                return vVoie;
            }
        };

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Voie> vListVoie = vJdbcTemplate.query(vSQL, vRowMapper, id);

        return vListVoie;
    }


    /**
     * Récupérer le nombre de voie d'un secteur
     * @param pSecteur secteur en parametre
     * @return nombre de voie
     */
    @Override
    public int getCountVoieSec(Secteur pSecteur) {
        String vSQL
                = "SELECT COUNT(*) FROM public.voie"
                + " WHERE id_secteur = :id_secteur";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_secteur", pSecteur.getIdSecteur());

        int vNbrVoie = vJdbcTemplate.queryForObject(vSQL, vParams, Integer.class);

        return vNbrVoie;
    }

    /**
     * Creer une voie
     * @param pVoie voie a creer
     * @return la voie creer
     */
    @Override
    public Voie insertVoie(Voie pVoie) {
        String vSQL = "INSERT INTO public.voie " +
                "  (id_topo,\n" +
                "  id_secteur,\n" +
                "  id_site,\n" +
                "  hauteur,\n" +
                "  cotation,\n" +
                "  nom_voie,\n" +
                "  description)\n" +
                "VALUES\n" +
                "(:idTopo,:idSecteur,:idSite,:hauteur,:cotation,:nom,:description)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("idTopo", pVoie.getId_topo());
        vParams.addValue("idSecteur", pVoie.getId_secteur());
        vParams.addValue("idSite", pVoie.getId_site());
        vParams.addValue("hauteur", pVoie.getHauteur());
        vParams.addValue("cotation", pVoie.getCotation());
        vParams.addValue("nom", pVoie.getNomVoie());
        vParams.addValue("description", pVoie.getDescription());

        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams, holder, new String[]{"id_voie"});
        pVoie.setIdVoie(holder.getKey().intValue());
        return pVoie;
    }

    /**
     * Mettre a jour une voie
     * @param pVoie la voie a modifier
     */
    @Override
    public void updateInfoVoie(Voie pVoie) {
        String vSQL = "UPDATE public.voie " +
                "SET description = :description,\n" +
                "nom_voie = :nom_voie,\n" +
                "cotation = :cotation,\n" +
                "hauteur = :hauteur,\n" +
                "id_secteur = :idSecteur,\n" +
                "id_topo = :idTopo,\n" +
                "id_site = :idSite " +
                "WHERE id_voie = :idVoie";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pVoie);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }
}
