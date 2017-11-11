
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 07/08/2017 13:26:18
-- Generated from EDMX file: c:\users\ali\documents\visual studio 2015\Projects\SportsApp\SportsApp\Models\FileModel.edmx
-- --------------------------------------------------

SET QUOTED_IDENTIFIER OFF;
GO
USE [sportsDB];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------


-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------



-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'FileDatas'
CREATE TABLE [dbo].[FileDatas] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [Tittle] nvarchar(max)  NOT NULL,
    [Description] nvarchar(max)  NOT NULL,
    [PdfUrl] nvarchar(max)  NOT NULL,
    [Category] nvarchar(max)  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [Id] in table 'FileDatas'
ALTER TABLE [dbo].[FileDatas]
ADD CONSTRAINT [PK_FileDatas]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------