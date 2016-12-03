package dam.lluchmk.numenerahandbook;

import android.os.Parcel;
import android.os.Parcelable;

public class Cypher implements Parcelable {

    private String type;
    private String name;
    private String level;
    private String wearable;
    private String usable;
    private String internal;
    private String effect;

    public Cypher() {
    }

    public Cypher(Parcel in) {
        this.type = in.readString();
        this.name = in.readString();
        this.level = in.readString();
        this.wearable = in.readString();
        this.usable = in.readString();
        this.internal= in.readString();
        this.effect = in.readString();
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternal() {
        return internal;
    }

    public void setInternal(String internal) {
        this.internal = internal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsable() {
        return usable;
    }

    public void setUsable(String usable) {
        this.usable = usable;
    }

    public String getWearable() {
        return wearable;
    }

    public void setWearable(String wearable) {
        this.wearable = wearable;
    }

    public void initializeFromItem(String item) {
        String[] data = item.split("---");
        type = data[0];
        name = data[1];
        level = data[2].replace("Level: ", "").trim();
        int diffUsage = 0;
        int wearablePos = item.indexOf("Wearable: ");
        if (wearablePos > 0) {
            wearable = data[3].replace("Wearable: ", "").trim();
            diffUsage++;
        }
        int usablePos = item.indexOf("Usable: ");
        if (usablePos > 0) {
            usable = data[3 + diffUsage].replace("Usable: ", "").trim();
            diffUsage++;
        }
        int internalPos = item.indexOf("Internal: ");
        if (internalPos > 0) {
            internal = data[3 + diffUsage].replace("Internal: ", "").trim();
            diffUsage++;
        }
        effect = data[3+diffUsage].replace("Effect: ", "").trim();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(name);
        dest.writeString(level);
        dest.writeString(wearable);
        dest.writeString(usable);
        dest.writeString(internal);
        dest.writeString(effect);
    }

    public static final Parcelable.Creator<Cypher> CREATOR = new Parcelable.Creator<Cypher>() {
        public Cypher createFromParcel(Parcel in) {
            return new Cypher(in);
        }

        public Cypher[] newArray(int size) {
            return new Cypher[size];
        }
    };
}
