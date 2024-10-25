package iteratorPattern;

import entities.SocialNetworkProfile;
import entities.UserProfile;
import entities.EnterpriseProfile;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ProfileIteratorEnterprises implements ProfileIterator<SocialNetworkProfile> {

    private Set<SocialNetworkProfile> visited;
    private Stack<SocialNetworkProfile> stack;

    public ProfileIteratorEnterprises(SocialNetworkProfile entryPoint) {
        visited = new HashSet<>();
        stack = new Stack<>();
        stack.push(entryPoint); // Agregar el punto de entrada al stack
    }

    @Override
    public SocialNetworkProfile getNext() {
        while (!stack.isEmpty()) {
            SocialNetworkProfile current = stack.pop();

            // Si ya se ha visitado, lo ignoramos
            if (visited.contains(current)) {
                continue;
            }

            // Marcarlo como visitado
            visited.add(current);

            // Si es un perfil de empresa, retornarlo
            if (current instanceof EnterpriseProfile) {
                return current; // Es un sink (empresa), devolverlo
            }

            // Si es un usuario, buscar en sus conexiones para encontrar empresas
            if (current instanceof UserProfile userProfile) {
                userProfile.getFollowing().stream()
                        .filter(profile -> !visited.contains(profile)) // Filtrar perfiles no visitados
                        .forEach(stack::push); // Agregar las conexiones al stack
            }
        }
        return null; // Si ya no quedan más empresas por recorrer
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty(); // Verificar si hay más nodos por recorrer
    }
}
