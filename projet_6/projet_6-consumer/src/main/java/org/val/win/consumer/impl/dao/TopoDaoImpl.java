package org.val.win.consumer.impl.dao;

import org.val.win.consumer.contract.dao.TopoDao;
import org.val.win.model.bean.grimpe.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {


    /**
     * Récupérer tous les topos
     * @return
     */
    @Override
    public List<Topo> getListTopo() {
        String vSQL = "SELECT * FROM public.topo";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Topo> vRowMapper = new RowMapper<Topo>() {
            public Topo mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Topo vTopo = new Topo(pRS.getInt("id_topo"));
                vTopo.setId_emprunteur(pRS.getInt("id_emprunteur"));
                vTopo.setId_utilisateur_createur(pRS.getInt("id_utilisateur_createur"));
                vTopo.setNom_topo(pRS.getString("nom_topo"));
                vTopo.setAncrage(pRS.getString("ancrage"));
                vTopo.setDescription(pRS.getString("description"));
                vTopo.setEtat(pRS.getBoolean("etat"));
                vTopo.setLieu(pRS.getString("lieu"));
                vTopo.setProfil(pRS.getString("profil"));
                vTopo.setRegion(pRS.getString("region"));
                vTopo.setRelai(pRS.getString("relai"));
                vTopo.setRoche((pRS.getString("roche")));
                return vTopo;
            }
        };
        List<Topo> vListTopo = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListTopo;
    }

    /**
     * Creer un nouveau topo
     * @param pTopo
     */
    @Override
    public void insertTopo(Topo pTopo) {
        String vSQL = "INSERT INTO public.topo " +
                "  (id_utilisateur_createur,\n" +
                "  nom_topo,\n" +
                "  region,\n" +
                "  lieu,\n" +
                "  roche,\n" +
                "  profil,\n" +
                "  ancrage,\n" +
                "  relai,\n" +
                "  etat,\n" +
                "  description)\n" +
                "VALUES\n" +
                "('0', '?', '?', '?', '?', '?', '?', '?', 'true', '?')";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_utilisateur_createur", pTopo.getId_utilisateur_createur());
        vParams.addValue("nom_topo", pTopo.getNom_topo());
        vParams.addValue("region", pTopo.getRegion());
        vParams.addValue("lieu", pTopo.getLieu());
        vParams.addValue("roche", pTopo.getRoche());
        vParams.addValue("profil", pTopo.getProfil());
        vParams.addValue("ancrage", pTopo.getAncrage());
        vParams.addValue("relai", pTopo.getRelai());
        vParams.addValue("etat", pTopo.getEtat());
        vParams.addValue("description", pTopo.getDescription());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }

    /**
     * Changer l'etat (DISPO) d'un topo
     * @param pTopo
     */
    @Override
    public void updateEtat(Topo pTopo) {
        String vSQL = "UPDATE public.topo SET etat = :etat WHERE id = :id";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pTopo);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }

    /**
     * Mettre a jour information topo
     * @param pTopo
     */
    @Override
    public void updateInfoTopo(Topo pTopo) {
        String vSQL = "UPDATE public.topo " +
                "SET description = :description,\n" +
                "nom_topo = :nom_topo,\n" +
                "region = :region,\n" +
                "lieu = :lieu,\n" +
                "roche = :roche,\n" +
                "profil = :profil,\n" +
                "ancrage = :ancrage,\n " +
                "relai = :relai " +
                "WHERE id = :id";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pTopo);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }
}