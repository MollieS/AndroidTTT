package mollie.tictactoe.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;

public class PlayAgainAlert extends DialogFragment {

    public Dialog createAlert() {
        return promptForPlayAgain(getContext());
    }

    private Dialog promptForPlayAgain(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Would you like to play again?")
                .setPositiveButton("yes", new PlayAgainClickListener())
                .setNegativeButton("no", new CancelDialogListener());
        return builder.create();
    }


    private class PlayAgainClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            getActivity().onBackPressed();
        }
    }

    private class CancelDialogListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }
}
