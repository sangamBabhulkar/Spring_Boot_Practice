package com.service.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nt.entity.ActorEntity;
import com.nt.utility.HibernateUtil;
import com.nt.vo.ActorVo;

@Repository
public class ActorDaoImpl implements IActorDao {

    // ================= FETCH ALL RECORDS =================
    @Override
    public List<ActorEntity> getAllActorDetails() {

        List<ActorEntity> list = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            list = session.createQuery("FROM ActorEntity", ActorEntity.class)
                          .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ================= INSERT RECORD =================
    @Override
    public int registerActorRepo(ActorVo vo) {

        Transaction tx = null;
        int result = 0;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            ActorEntity entity = new ActorEntity();
            entity.setAname(vo.getAname());
            entity.setAddrs(vo.getAddrs());
            entity.setCat(vo.getCat());
            entity.setFees(vo.getFees());

            session.save(entity);

            tx.commit();
            result = 1;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return result;
    }

    // ================= DELETE RECORD =================
    @Override
    public int deleteActorById(int id) {

        Transaction tx = null;
        int result = 0;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            ActorEntity entity = session.get(ActorEntity.class, id);

            if (entity != null) {
                session.delete(entity);
                result = 1;
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return result;
    }

    // ================= GET BY ID =================
    @Override
    public ActorEntity getActorById(int id) {

        ActorEntity entity = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            entity = session.get(ActorEntity.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    // ================= UPDATE RECORD =================
    @Override
    public int updateActor(ActorVo vo) {

        Transaction tx = null;
        int result = 0;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            ActorEntity entity = session.get(ActorEntity.class, vo.getAid());

            if (entity != null) {
                entity.setAname(vo.getAname());
                entity.setAddrs(vo.getAddrs());
                entity.setCat(vo.getCat());
                entity.setFees(vo.getFees());

                session.update(entity);
                result = 1;
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return result;
    }
}
