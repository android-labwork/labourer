package com.aitekteam.developer.labourer.Handlers;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseHandler {
    private DatabaseReference db;
    private FirebaseHandlerDB handler;

    public FirebaseHandler(FirebaseHandlerDB handler) {
        this.db = FirebaseDatabase.getInstance().getReference();
        this.handler = handler;
    }

    public void create(int validation) {
        this.handler.create(this.db, validation);
    }

    public void valueEvent(int validation) {
        this.handler.getWithValueEvent(this.db, validation);
    }

    public void childEvent(int validation) {
        this.handler.getWithChildEvent(this.db, validation);
    }

    public interface FirebaseHandlerDB {
        void create(DatabaseReference db, int validation);
        ValueEventListener getWithValueEvent(DatabaseReference db, int validation);
        ChildEventListener getWithChildEvent(DatabaseReference db, int validation);
    }
}
