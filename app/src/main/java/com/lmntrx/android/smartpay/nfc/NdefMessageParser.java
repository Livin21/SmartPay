package com.lmntrx.android.smartpay.nfc;

import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lmntrx.android.smartpay.R;
import com.lmntrx.android.smartpay.nfc.record.ParsedNdefRecord;
import com.lmntrx.android.smartpay.nfc.record.SmartPoster;
import com.lmntrx.android.smartpay.nfc.record.TextRecord;
import com.lmntrx.android.smartpay.nfc.record.UriRecord;

import java.util.ArrayList;
import java.util.List;


public class NdefMessageParser {

    static String stringValue;

    // Utility class
    private NdefMessageParser() {

    }

    /** Parse an NdefMessage */
    static List<ParsedNdefRecord> parse(NdefMessage message) {
        return getRecords(message.getRecords());
    }

    public static List<ParsedNdefRecord> getRecords(NdefRecord[] records) {
        List<ParsedNdefRecord> elements = new ArrayList<>();
        for (final NdefRecord record : records) {
            if (UriRecord.isUri(record)) {
                elements.add(UriRecord.parse(record));
            } else if (TextRecord.isText(record)) {
                elements.add(TextRecord.parse(record));
            } else if (SmartPoster.isPoster(record)) {
                elements.add(SmartPoster.parse(record));
            } else {
                elements.add(new ParsedNdefRecord() {
                    @Override
                    public View getView(Activity activity, LayoutInflater inflater, ViewGroup parent, int offset) {
                        TextView text = (TextView) inflater.inflate(R.layout.tag_text, parent, false);
                        text.setText(new String(record.getPayload()));
                        stringValue=text.getText().toString();
                        return text;
                    }

                });
            }
        }
        return elements;
    }
}