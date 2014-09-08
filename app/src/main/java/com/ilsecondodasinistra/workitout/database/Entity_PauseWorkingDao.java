package com.ilsecondodasinistra.workitout.database;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.ilsecondodasinistra.workitout.database.Entity_PauseWorking;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table PausesWorking.
*/
public class Entity_PauseWorkingDao extends AbstractDao<Entity_PauseWorking, Integer> {

    public static final String TABLENAME = "PausesWorking";

    /**
     * Properties of entity Entity_PauseWorking.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id_pauseworking = new Property(0, int.class, "id_pauseworking", true, "ID_PAUSEWORKING");
        public final static Property Start_date = new Property(1, java.util.Date.class, "start_date", false, "START_DATE");
        public final static Property End_date = new Property(2, java.util.Date.class, "end_date", false, "END_DATE");
        public final static Property Id_sessionworking = new Property(3, int.class, "id_sessionworking", false, "ID_SESSIONWORKING");
    };

    private Query<Entity_PauseWorking> entity_SessionWorking_PausesQuery;

    public Entity_PauseWorkingDao(DaoConfig config) {
        super(config);
    }
    
    public Entity_PauseWorkingDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'PausesWorking' (" + //
                "'ID_PAUSEWORKING' INTEGER PRIMARY KEY NOT NULL ," + // 0: id_pauseworking
                "'START_DATE' INTEGER NOT NULL ," + // 1: start_date
                "'END_DATE' INTEGER NOT NULL ," + // 2: end_date
                "'ID_SESSIONWORKING' INTEGER NOT NULL );"); // 3: id_sessionworking
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'PausesWorking'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Entity_PauseWorking entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId_pauseworking());
        stmt.bindLong(2, entity.getStart_date().getTime());
        stmt.bindLong(3, entity.getEnd_date().getTime());
        stmt.bindLong(4, entity.getId_sessionworking());
    }

    /** @inheritdoc */
    @Override
    public Integer readKey(Cursor cursor, int offset) {
        return cursor.getInt(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Entity_PauseWorking readEntity(Cursor cursor, int offset) {
        Entity_PauseWorking entity = new Entity_PauseWorking( //
            cursor.getInt(offset + 0), // id_pauseworking
            new java.util.Date(cursor.getLong(offset + 1)), // start_date
            new java.util.Date(cursor.getLong(offset + 2)), // end_date
            cursor.getInt(offset + 3) // id_sessionworking
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Entity_PauseWorking entity, int offset) {
        entity.setId_pauseworking(cursor.getInt(offset + 0));
        entity.setStart_date(new java.util.Date(cursor.getLong(offset + 1)));
        entity.setEnd_date(new java.util.Date(cursor.getLong(offset + 2)));
        entity.setId_sessionworking(cursor.getInt(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Integer updateKeyAfterInsert(Entity_PauseWorking entity, long rowId) {
        return entity.getId_pauseworking();
    }
    
    /** @inheritdoc */
    @Override
    public Integer getKey(Entity_PauseWorking entity) {
        if(entity != null) {
            return entity.getId_pauseworking();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "pauses" to-many relationship of Entity_SessionWorking. */
    public List<Entity_PauseWorking> _queryEntity_SessionWorking_Pauses(int id_sessionworking) {
        synchronized (this) {
            if (entity_SessionWorking_PausesQuery == null) {
                QueryBuilder<Entity_PauseWorking> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Id_sessionworking.eq(null));
                entity_SessionWorking_PausesQuery = queryBuilder.build();
            }
        }
        Query<Entity_PauseWorking> query = entity_SessionWorking_PausesQuery.forCurrentThread();
        query.setParameter(0, id_sessionworking);
        return query.list();
    }

}