package com.f1analysis.service;

import com.f1analysis.models.User;
import com.f1analysis.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Service for user management.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    // TODO: Inject PasswordEncoder when Spring Security is enabled
    // private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ==================== Registration ====================

    /**
     * Register a new user.
     * 
     * TODO: Implement this method
     * - Validate email format
     * - Check if email already exists
     * - Hash password (use PasswordEncoder)
     * - Save user
     */
    public User registerUser(String email, String password, String displayName) {
        // TODO: Implement user registration
        
        // 1. Validate inputs
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }

        // 2. Check if email exists
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already registered");
        }

        // 3. Create user
        User user = new User();
        user.setEmail(email);
        user.setDisplayName(displayName);
        user.setCreatedAt(LocalDateTime.now());
        user.setRole(User.Role.USER);

        // TODO: Hash password properly when Spring Security is enabled
        // user.setPassword(passwordEncoder.encode(password));
        user.setPassword(password); // TEMPORARY - not secure!

        // 4. Save and return
        return userRepository.save(user);
    }

    // ==================== Authentication ====================

    /**
     * Authenticate a user.
     * 
     * TODO: Implement this method
     * - Find user by email
     * - Verify password
     * - Update last login timestamp
     * - Return user if valid
     */
    public Optional<User> authenticateUser(String email, String password) {
        // TODO: Implement authentication
        // 1. Find user by email
        // 2. Check password with passwordEncoder.matches()
        // 3. Update lastLogin
        // 4. Return user
        throw new UnsupportedOperationException("TODO: Implement authenticateUser");
    }

    // ==================== Profile Management ====================

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Update user profile.
     * 
     * TODO: Implement this method
     */
    public User updateProfile(Long userId, String displayName, String avatarUrl) {
        // TODO: Implement profile update
        // 1. Find user by ID
        // 2. Update fields
        // 3. Save and return
        throw new UnsupportedOperationException("TODO: Implement updateProfile");
    }

    /**
     * Change user password.
     * 
     * TODO: Implement this method
     */
    public void changePassword(Long userId, String oldPassword, String newPassword) {
        // TODO: Implement password change
        // 1. Find user
        // 2. Verify old password
        // 3. Hash new password
        // 4. Save
        throw new UnsupportedOperationException("TODO: Implement changePassword");
    }

    // ==================== Admin ====================

    /**
     * Promote user to premium.
     */
    public void upgradeUserToPremium(Long userId) {
        // TODO: Implement premium upgrade
        throw new UnsupportedOperationException("TODO: Implement upgradeUserToPremium");
    }
}
