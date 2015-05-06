package com.loresky.zoom.test.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cy on 15-5-6.
 */
public class ParcelableDeveloper implements Parcelable {
    private String name;
    private int yearsOfExperience;
    public List<Skill> skillSet;
    public float favoriteFloat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public List<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(List<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    public float getFavoriteFloat() {
        return favoriteFloat;
    }

    public void setFavoriteFloat(float favoriteFloat) {
        this.favoriteFloat = favoriteFloat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.yearsOfExperience);
        dest.writeTypedList(skillSet);
        dest.writeFloat(this.favoriteFloat);
    }

    public ParcelableDeveloper() {
    }

    private ParcelableDeveloper(Parcel in) {
        this.name = in.readString();
        this.yearsOfExperience = in.readInt();
        skillSet = new ArrayList<Skill>();
        in.readTypedList(skillSet, Skill.CREATOR);
        this.favoriteFloat = in.readFloat();
    }

    public static final Creator<ParcelableDeveloper> CREATOR = new Creator<ParcelableDeveloper>() {
        public ParcelableDeveloper createFromParcel(Parcel source) {
            return new ParcelableDeveloper(source);
        }

        public ParcelableDeveloper[] newArray(int size) {
            return new ParcelableDeveloper[size];
        }
    };


    public static class Skill implements Parcelable {
        public String name;
        public boolean programmingRelated;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isProgrammingRelated() {
            return programmingRelated;
        }

        public void setProgrammingRelated(boolean programmingRelated) {
            this.programmingRelated = programmingRelated;
        }

        /**
         * 内容描述接口，基本不用管
         */
        @Override
        public int describeContents() {
            return 0;
        }

        /**
         * 写入接口函数，打包
         */
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeByte(programmingRelated ? (byte) 1 : (byte) 0);
        }

        public Skill() {
        }

        private Skill(Parcel in) {
            this.name = in.readString();
            this.programmingRelated = in.readByte() != 0;
        }

        /**
         * 读取接口，目的是要从Parcel中构造一个实现了Parcelable的类的实例处理。因为实现类在这里还是不可知的，所以需要用到模板的方式，继承类名通过模板参数传入
         * 为了能够实现模板参数的传入，这里定义Creator嵌入接口,内含两个接口函数分别返回单个和多个继承类实例
         */
        public static final Creator<Skill> CREATOR = new Creator<Skill>() {
            public Skill createFromParcel(Parcel source) {
                return new Skill(source);
            }

            public Skill[] newArray(int size) {
                return new Skill[size];
            }
        };
    }


}
