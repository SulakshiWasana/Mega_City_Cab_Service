<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/8/2025
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="welcome-content">
    <h2>Welcome to Mega City Cab Service</h2>
    <p class="lead">Your reliable partner for seamless and comfortable travel experiences across the city.</p>

    <!-- Key Features Section -->
    <div class="features">
        <div class="row">
            <!-- Feature 1: Fast Booking -->
            <div class="col-md-4">
                <div class="feature-card">
                    <i class="fas fa-tachometer-alt fa-3x"></i>
                    <h4>Fast Booking</h4>
                    <p>Book a cab in just a few clicks and get instant confirmation.</p>
                </div>
            </div>

            <!-- Feature 2: Affordable Fares -->
            <div class="col-md-4">
                <div class="feature-card">
                    <i class="fas fa-dollar-sign fa-3x"></i>
                    <h4>Affordable Fares</h4>
                    <p>Enjoy competitive pricing with no hidden charges.</p>
                </div>
            </div>

            <!-- Feature 3: 24/7 Support -->
            <div class="col-md-4">
                <div class="feature-card">
                    <i class="fas fa-headset fa-3x"></i>
                    <h4>24/7 Support</h4>
                    <p>We're here to assist you anytime, anywhere.</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Statistics Section -->
    <div class="statistics">
        <h3>Our Achievements</h3>
        <div class="row">
            <!-- Statistic 1: Total Rides -->
            <div class="col-md-4">
                <div class="stat-card">
                    <h2>10,000+</h2>
                    <p>Total Rides Completed</p>
                </div>
            </div>

            <!-- Statistic 2: Happy Customers -->
            <div class="col-md-4">
                <div class="stat-card">
                    <h2>95%</h2>
                    <p>Customer Satisfaction Rate</p>
                </div>
            </div>

            <!-- Statistic 3: Active Drivers -->
            <div class="col-md-4">
                <div class="stat-card">
                    <h2>500+</h2>
                    <p>Active Drivers</p>
                </div>
            </div>
        </div>
    </div>
</div>

<style>
    /* Welcome Content Styles */
    .welcome-content {
        text-align: center;
        padding: 20px;
    }

    .welcome-content h2 {
        color: #333;
        font-weight: 700;
        margin-bottom: 20px;
    }

    .welcome-content .lead {
        font-size: 18px;
        color: #666;
        margin-bottom: 40px;
    }

    /* Feature Cards */
    .feature-card {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        transition: transform 0.3s ease;
    }

    .feature-card:hover {
        transform: translateY(-5px);
    }

    .feature-card i {
        color: #6c5ce7;
        margin-bottom: 15px;
    }

    .feature-card h4 {
        color: #333;
        font-weight: 600;
        margin-bottom: 10px;
    }

    .feature-card p {
        color: #666;
        font-size: 14px;
    }

    /* Statistics Section */
    .statistics {
        margin-top: 40px;
    }

    .statistics h3 {
        color: #333;
        font-weight: 700;
        margin-bottom: 30px;
    }

    .stat-card {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }

    .stat-card h2 {
        color: #6c5ce7;
        font-weight: 700;
        margin-bottom: 10px;
    }

    .stat-card p {
        color: #666;
        font-size: 14px;
    }
</style>
</html>
