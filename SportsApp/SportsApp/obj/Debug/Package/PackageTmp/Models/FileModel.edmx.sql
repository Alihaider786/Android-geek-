
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 10/12/2017 11:08:28
-- Generated from EDMX file: C:\Users\ALi\documents\visual studio 2015\Projects\SportsApp\SportsApp\Models\FileModel.edmx
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

IF OBJECT_ID(N'[dbo].[FileDatas]', 'U') IS NOT NULL
    DROP TABLE [dbo].[FileDatas];
GO
IF OBJECT_ID(N'[dbo].[NewsDatas]', 'U') IS NOT NULL
    DROP TABLE [dbo].[NewsDatas];
GO
IF OBJECT_ID(N'[dbo].[Images]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Images];
GO
IF OBJECT_ID(N'[dbo].[Videos]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Videos];
GO

-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'FileDatas'
CREATE TABLE [dbo].[FileDatas] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [Tittle] nvarchar(max)  NOT NULL,
    [Description] nvarchar(max)  NOT NULL,
    [PdfUrl] nvarchar(max)  NOT NULL,
    [Category] nvarchar(max)  NOT NULL,
    [createdBy] nvarchar(max)  NOT NULL,
    [Date] nvarchar(max)  NOT NULL,
    [Visibility] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'NewsDatas'
CREATE TABLE [dbo].[NewsDatas] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [Author] nvarchar(max)  NOT NULL,
    [title] nvarchar(max)  NOT NULL,
    [Description] nvarchar(max)  NOT NULL,
    [PublishedAt] nvarchar(max)  NOT NULL,
    [Url] nvarchar(max)  NOT NULL,
    [UrlToImage] nvarchar(max)  NOT NULL,
    [Category] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'Images'
CREATE TABLE [dbo].[Images] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [UrlToImage] nvarchar(max)  NOT NULL,
    [Categoty] nvarchar(max)  NOT NULL,
    [Title] nvarchar(max)  NOT NULL,
    [Description] nvarchar(max)  NOT NULL,
    [Visibility] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'Videos'
CREATE TABLE [dbo].[Videos] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [UrlToVideo] nvarchar(max)  NOT NULL,
    [Category] nvarchar(max)  NOT NULL,
    [Title] nvarchar(max)  NOT NULL,
    [Description] nvarchar(max)  NOT NULL,
    [Visibility] nvarchar(max)  NOT NULL
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

-- Creating primary key on [Id] in table 'NewsDatas'
ALTER TABLE [dbo].[NewsDatas]
ADD CONSTRAINT [PK_NewsDatas]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'Images'
ALTER TABLE [dbo].[Images]
ADD CONSTRAINT [PK_Images]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'Videos'
ALTER TABLE [dbo].[Videos]
ADD CONSTRAINT [PK_Videos]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------