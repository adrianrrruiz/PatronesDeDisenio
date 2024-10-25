package entities;

import iteratorPattern.*;

import java.util.LinkedList;
import java.util.List;

public class UserProfile implements SocialNetworkProfile, SocialNetworkIterable<ProfileIterator<SocialNetworkProfile>> {

    private List<SocialNetworkProfile> following;
    private String userName;
    private int age;

    public UserProfile(String userName, int age){
        this.following = new LinkedList<>();
        this.userName = userName;
        this.age = age;
    }

    public void addFollowing(SocialNetworkProfile...profiles){
        for (SocialNetworkProfile profile : profiles) {
            this.following.add(profile);
        }
    }

    public List<SocialNetworkProfile> getFollowing(){
        return  this.following;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof UserProfile other){
            if(other.getUserName().equals(this.userName) && other.age == this.age) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        Integer n = age;
        return userName.hashCode() + n.hashCode();
    }

    @Override
    public String toString() {
        return "I'm " + userName + " and I'm " + age + " years old";
    }

    @Override
    public ProfileIterator<SocialNetworkProfile> iterator() {
        return new ProfileIteratorEnterprises(this);
    }
}
