package iteratorPattern;

import entities.SocialNetworkProfile;
import entities.UserProfile;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ProfileIteratorUsersDFS implements ProfileIterator<SocialNetworkProfile>{

    private Set<SocialNetworkProfile> visited;
    private Stack<SocialNetworkProfile> stack;

    public ProfileIteratorUsersDFS(SocialNetworkProfile entryPoint) {
        visited = new HashSet<>();
        stack = new Stack<>();
        stack.push(entryPoint); // Agregar el punto de entrada al stack para empezar el recorrido
    }

    @Override
    public SocialNetworkProfile getNext() {
        while (!stack.isEmpty()) {
            SocialNetworkProfile current = stack.pop(); // Obtener el siguiente nodo en profundidad

            // Si ya se visitó este nodo, continuar con el siguiente
            if (visited.contains(current)) {
                continue;
            }

            // Marcarlo como visitado
            visited.add(current);

            // Si el perfil es un usuario, agregar sus seguidores al stack para continuar el recorrido DFS
            if (current instanceof UserProfile userProfile) {
                userProfile.getFollowing().stream()
                        .filter(profile -> !visited.contains(profile)) // Filtrar perfiles no visitados
                        .filter((follower)->follower instanceof UserProfile)
                        .forEach(stack::push); // Agregar los perfiles no visitados al stack
            }

            // Retornar el nodo actual, que no había sido visitado aún
            return current;
        }

        return null; // Si ya no hay más nodos para recorrer
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty(); // Hay más nodos si el stack no está vacío
    }
}
