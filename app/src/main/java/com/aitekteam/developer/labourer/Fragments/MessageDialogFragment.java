package com.aitekteam.developer.labourer.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.aitekteam.developer.labourer.R;

public class MessageDialogFragment extends DialogFragment {
    private MessageDialogHandler handler;
    private String msg, title;

    public MessageDialogFragment(String msg, String title, MessageDialogHandler handler) {
        this.handler = handler;
        this.msg = msg;
        this.title = title;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(this.msg)
                .setTitle(this.title)
                .setPositiveButton(R.string.yes_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        handler.doAction();
                    }
                })
                .setNegativeButton(R.string.no_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        handler.rejectAction();
                    }
                });
        return builder.create();
    }

    public interface MessageDialogHandler {
        void doAction();
        void rejectAction();
    }
}
