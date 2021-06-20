<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="navbar-nav sidebar sidebar-light accordion" id="accordionSidebar">
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/ecommerce">
        <div class="sidebar-brand-icon">
          <img src='<c:url value="/resources/admin/img/logo/logo2.png" />' />
        </div>
        <div class="sidebar-brand-text mx-3">RuangAdmin</div>
      </a>
      <hr class="sidebar-divider my-0">
      <li class="nav-item active">
        <a class="nav-link" href="/ecommerce/admin">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>
      <hr class="sidebar-divider">
      <div class="sidebar-heading">
        Features
      </div>
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseForm" aria-expanded="true"
          aria-controls="collapseForm">
          <i class="fab fa-fw fa-wpforms"></i>
          <span>Quản Lý</span>
        </a>
        <div id="collapseForm" class="collapse" aria-labelledby="headingForm" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
           	<h6 class="collapse-header">Quản Lý</h6>
            <a class="collapse-item" href="http://localhost:8080/ecommerce/admin/sanpham">Quản lý sản phẩm</a>
            <a class="collapse-item" href="http://localhost:8080/ecommerce/admin/danhmuc">Quản lý danh mục</a>
            <a class="collapse-item" href="http://localhost:8080/ecommerce/admin/qluser">Quản lý user</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTable" aria-expanded="true"
          aria-controls="collapseTable">
          <i class="fas fa-fw fa-table"></i>
          <span>Thống Kê</span>
        </a>
        <div id="collapseTable" class="collapse" aria-labelledby="headingTable" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Thống kê</h6>
            <a class="collapse-item" href="http://localhost:8080/ecommerce/admin/thongke-sanpham">Sản phẩm</a>
          </div>
        </div>
      </li>
    </ul>