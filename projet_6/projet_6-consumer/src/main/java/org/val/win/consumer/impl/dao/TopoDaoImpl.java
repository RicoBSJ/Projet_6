package org.val.win.consumer.impl.dao;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.val.win.consumer.contract.dao.TopoDao;
import org.val.win.model.bean.grimpe.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.inject.Named;
import javax.naming.Name;
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
                vTopo.setIdEmprunteur(pRS.getInt("id_emprunteur"));
                vTopo.setIdUtilisateurCreateur(pRS.getInt("id_utilisateur_createur"));
                vTopo.setNomTopo(pRS.getString("nom_topo"));
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
    public Topo insertTopo(final Topo pTopo) {
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
                "(:idUtilisateurCreateur, :nomTopo, :region, :lieu, :roche, :profil, :ancrage, :relai, :etat, :description)";

        SqlParameterSource vParams = new MapSqlParameterSource()
            .addValue("idUtilisateurCreateur", pTopo.getIdUtilisateurCreateur())
            .addValue("nomTopo", pTopo.getNomTopo())
            .addValue("region", pTopo.getRegion())
            .addValue("lieu", pTopo.getLieu())
            .addValue("roche", pTopo.getRoche())
            .addValue("profil", pTopo.getProfil())
            .addValue("ancrage", pTopo.getAncrage())
            .addValue("relai", pTopo.getRelai())
            .addValue("etat", pTopo.getEtat())
            .addValue("description", pTopo.getDescription());

        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams, holder, new String[]{"id_topo"});
        pTopo.setIdTopo(holder.getKey().intValue());
        return pTopo;
    }

    /**
     * Reserver un Topo
     * @param pTopo
     */
    @Override
    public void emprunt(final Topo pTopo){
        String vSQL = "UPDATE public.topo " +
                "SET date_debut_emprunt =:dateEmp, " +
                "date_fin_emprunt =:dateRet, " +
                "id_emprunteur =:idEmprunteur " +
                "WHERE id_topo =:idTopo";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pTopo);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    /**
     * Mettre a jour information topo
     * @param pTopo
     */
    @Override
    public void updateInfoTopo(final Topo pTopo) {
        String vSQL = "UPDATE public.topo " +
                "SET description = :description,\n" +
                "nom_topo = :nom_topo,\n" +
                "region = :region,\n" +
                "lieu = :lieu,\n" +
                "roche = :roche,\n" +
                "profil = :profil,\n" +
                "ancrage = :ancrage,\n " +
                "relai = :relai " +
                "WHERE id_topo = :idTopo";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pTopo);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }
}
