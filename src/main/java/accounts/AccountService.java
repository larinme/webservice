package accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private final Map<String, UserProfile> loginToProfile;
    private final Map<String, UserProfile> sessionIdToProfile;

    public AccountService(){

        loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
    }


    public void addNewUser(UserProfile profile) {
        loginToProfile.put(profile.getLogin(), profile);
    }

    public UserProfile getUserProfile(String login) {
        return loginToProfile.get(login);
    }

    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public UserProfile getUserProfileBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
